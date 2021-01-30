package com.jian.simplecalandar.calendar.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.jian.simplecalandar.App
import com.jian.simplecalandar.R
import com.jian.simplecalandar.calendar.CalendarContract
import com.jian.simplecalandar.calendar.CalendarModule
import com.jian.simplecalandar.calendar.DaggerCalendarComponent
import com.jian.simplecalandar.calendar.data.CalendarDate
import com.jian.simplecalandar.gone
import com.jian.simplecalandar.visible
import javax.inject.Inject

class CalendarFragment: Fragment(),
    CalendarContract.View {

    @Inject
    lateinit var calendarPresenter: CalendarContract.Presenter

    @BindView(R.id.swipe_to_refresh)
    lateinit var swipeToRefresh: SwipeRefreshLayout

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView

    @BindView(R.id.progress)
    lateinit var progressSpinner: ProgressBar

    lateinit var adapter: CalendarAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
        ButterKnife.bind(this, view)

        DaggerCalendarComponent.builder()
            .componentApplication((requireContext().applicationContext as App).applicationComponent)
            .calendarModule(
                CalendarModule(
                    this,
                    this
                )
            )
            .build().inject(this)


        adapter = CalendarAdapter(requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        calendarPresenter.getCalendarWithDoggos()

        swipeToRefresh.setOnRefreshListener {
            calendarPresenter.getCalendarWithDoggos()
        }

        return view
    }

    override fun showLoading() {
        progressSpinner.visible()
    }

    override fun renderCalendar(calendarWeek: List<CalendarDate>) {
        swipeToRefresh.isRefreshing = false
        progressSpinner.gone()
        adapter.updateCalendarItems(calendarWeek)
    }

    override fun showError(exception: Exception) {
        swipeToRefresh.isRefreshing = false
        progressSpinner.gone()
        Toast.makeText(requireContext(), requireContext().getString(R.string.error_message, exception.message), Toast.LENGTH_LONG).show()
    }

}
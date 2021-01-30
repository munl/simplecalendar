package com.jian.simplecalandar.calendar.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.jian.simplecalandar.R
import com.jian.simplecalandar.calendar.CalendarUtils
import com.jian.simplecalandar.calendar.CalendarUtils.isToday
import com.jian.simplecalandar.calendar.data.CalendarDate
import com.jian.simplecalandar.gone
import com.jian.simplecalandar.visible
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_calendar.view.*

class CalendarAdapter(val context: Context) : RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    var calendarDates: List<CalendarDate> = arrayListOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    fun updateCalendarItems(calendarDates: List<CalendarDate>) {
        this.calendarDates = calendarDates
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.calendar_item, parent, false))
    }

    override fun getItemCount(): Int {
        return calendarDates.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            val calendarDate = calendarDates[position].date
            if(calendarDate.isToday()) currentDateIndicator.visible()
            else currentDateIndicator.gone()

            date.text = CalendarUtils.getDateFormat(calendarDates[position].date)
            Picasso.get()
                .load(calendarDates[position].imageUrl)
                .into(image)

        }
    }

    override fun onViewRecycled(holder: ViewHolder) {
        holder.apply {
            image.setImageDrawable(null)
            Picasso.get().cancelRequest(image)
        }
        super.onViewRecycled(holder)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.current_date_indicator)
        lateinit var currentDateIndicator: ImageView

        @BindView(R.id.date)
        lateinit var date: TextView

        @BindView(R.id.image)
        lateinit var image: ImageView
        init {
            ButterKnife.bind(this, itemView)
        }
    }
}
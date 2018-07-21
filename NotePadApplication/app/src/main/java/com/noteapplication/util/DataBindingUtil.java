package com.noteapplication.util;


import android.databinding.BindingAdapter;
import android.widget.TextView;

public class DataBindingUtil {

    @BindingAdapter("format_nb_date")
    public static void formatNoteBookItemDate(TextView view, long date){
        view.setText(DateTimeUtil.getFormattedDate(date, DateTimeUtil.UI_DATE_FORMAT));
    }
}

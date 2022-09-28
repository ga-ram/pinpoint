package com.navercorp.pinpoint.metric.web.view;

import java.util.List;

public interface TimeSeriesValueView {
    public String getFieldName();
    public List<String> getTags();
    public List<? extends Number> getValues();
}

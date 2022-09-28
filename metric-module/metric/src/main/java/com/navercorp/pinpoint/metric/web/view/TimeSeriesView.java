package com.navercorp.pinpoint.metric.web.view;

import java.util.List;

public interface TimeSeriesView {
    String getTitle();

    String getUnit();

    public List<Long> getTimestamp();

    List<TimeseriesValueGroupView> getMetricValueGroups();

}

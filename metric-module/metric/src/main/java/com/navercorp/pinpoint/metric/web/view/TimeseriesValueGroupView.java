package com.navercorp.pinpoint.metric.web.view;

import java.util.List;

public interface TimeseriesValueGroupView {
    String getGroupName();

    List<TimeSeriesValueView> getMetricValues();

}

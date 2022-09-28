package com.navercorp.pinpoint.metric.web.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.navercorp.pinpoint.metric.common.model.UriStat;
import com.navercorp.pinpoint.metric.web.model.UriStatGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UriStatView implements TimeSeriesView {

    private final List<Long> timestampList;

    private final List<TimeseriesValueGroupView> uriStats = new ArrayList<>();

    public UriStatView(String uri, List<UriStat> uriStats) {
        Objects.requireNonNull(uriStats, "uriStats");
        this.timestampList = uriStats.stream().map(UriStat::getTimestamp).collect(Collectors.toList());
        if (uriStats.isEmpty()) {
            this.uriStats.add(UriStatGroup.EMPTY_URI_STAT_GROUP);
        } else {
            this.uriStats.add(new UriStatGroup(uri, uriStats));
        }
    }

    @Override
    public String getTitle() { return "uriStat"; }

    @Override
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getUnit() { return null; }

    @Override
    public List<Long> getTimestamp() { return timestampList;}

    @Override
    public List<TimeseriesValueGroupView> getMetricValueGroups() {
        return uriStats;
    }

}

package com.navercorp.pinpoint.metric.web.service;

import com.navercorp.pinpoint.metric.common.model.UriStat;
import com.navercorp.pinpoint.metric.web.model.UriStatSummary;
import com.navercorp.pinpoint.metric.web.util.TimeWindow;
import com.navercorp.pinpoint.metric.web.util.UriStatQueryParameter;

import java.util.List;

public interface UriStatService {
    List<UriStat> getCollectedUriStatApplication(UriStatQueryParameter queryParameter, TimeWindow timeWindow);
    List<UriStat> getCollectedUriStatAgent(UriStatQueryParameter queryParameter, TimeWindow timeWindow);
    List<UriStatSummary> getUriStatApplicationSummary(UriStatQueryParameter queryParameter);
    List<UriStatSummary> getUriStatAgentSummary(UriStatQueryParameter queryParameter);
}

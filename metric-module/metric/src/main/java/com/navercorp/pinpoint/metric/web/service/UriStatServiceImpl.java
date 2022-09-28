package com.navercorp.pinpoint.metric.web.service;

import com.navercorp.pinpoint.metric.common.model.UriStat;
import com.navercorp.pinpoint.metric.web.dao.UriStatDao;
import com.navercorp.pinpoint.metric.web.model.UriStatSummary;
import com.navercorp.pinpoint.metric.web.util.TimeWindow;
import com.navercorp.pinpoint.metric.web.util.UriStatQueryParameter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UriStatServiceImpl implements UriStatService {

    private UriStatDao uriStatDao;

    public UriStatServiceImpl(UriStatDao uriStatDao) {
        this.uriStatDao = Objects.requireNonNull(uriStatDao);
    }

    @Override
    public List<UriStat> getCollectedUriStatApplication(UriStatQueryParameter queryParameter, TimeWindow timeWindow) {
        return uriStatDao.getUriStatApplication(queryParameter);
    }

    @Override
    public List<UriStat> getCollectedUriStatAgent(UriStatQueryParameter queryParameter, TimeWindow timeWindow) {
        return uriStatDao.getUriStatAgent(queryParameter);
    }

    @Override
    public List<UriStatSummary> getUriStatApplicationSummary(UriStatQueryParameter queryParameter) {
        return uriStatDao.getUriStatApplicationSummary(queryParameter);
    }

    @Override
    public List<UriStatSummary> getUriStatAgentSummary(UriStatQueryParameter queryParameter) {
        return uriStatDao.getUriStatAgentSummary(queryParameter);
    }
}

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class UrlStatisticDataService {
    private url = 'getAgentStat/uriStat/chartList.pinpoint';

    constructor(
        private http: HttpClient,
    ) {}

    getData(): Observable<any> {
        return this.http.get<any>(this.url, this.makeRequestOptionsArgs());
    }

    private makeRequestOptionsArgs(): any {
        // TODO: Deliver real param
        return {
            params: {
                agentId: 'garam-agent',
                from: 1663704252000,
                to: 1663725852000,
                sampleRate: 1
            }
        };
    }
}

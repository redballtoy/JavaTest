package StreamAPI.legasy;

import java.util.List;
import java.util.Map;

public interface AccountRequestProcessorService {
    public void sendRequest(Map<Long,List<RequestDataRow>> managerRequestDataRows);
}

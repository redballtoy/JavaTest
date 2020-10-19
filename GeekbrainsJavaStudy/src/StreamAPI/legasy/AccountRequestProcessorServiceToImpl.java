package StreamAPI.legasy;


import sun.plugin2.message.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRequestProcessorServiceToImpl implements AccountRequestProcessorService {
    private final CoverLetterService coverLetterService;
    private final SendRequestListService sendRequestListService;

    public AccountRequestProcessorServiceToImpl(CoverLetterService coverLetterService
            , SendRequestListService sendRequestListService) {
        this.coverLetterService = coverLetterService;
        this.sendRequestListService = sendRequestListService;
    }

    @Override
    public void sendRequest(Map<Long, List<RequestDataRow>> managerRequestDataRows) {

        //объединяем все списки в один
        List<RequestDataRow> allDataRows = new ArrayList<RequestDataRow>();

        //группируем по банку
        Map<Long, List<RequestDataRow>> bankListmap = new HashMap<Long, List<RequestDataRow>>();

        //создаем сопроводительные письма
        List<CoverLetter> coverLetterList = new ArrayList<CoverLetter>();

        //создаем сообщения
        List<Message> messageList = new ArrayList<Message>();

        //отправляем сообщения
        sendRequestListService.sendAll(messageList);

    }

}

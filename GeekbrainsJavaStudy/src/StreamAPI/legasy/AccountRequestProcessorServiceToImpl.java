package StreamAPI.legasy;


import sun.plugin2.message.Message;

import java.time.LocalDate;
import java.util.*;

public class AccountRequestProcessorServiceToImpl implements AccountRequestProcessorService {
    private final CoverLetterService coverLetterService;
    private final SendRequestListService sendRequestListService;

    public AccountRequestProcessorServiceToImpl(CoverLetterService coverLetterService
            , SendRequestListService sendRequestListService) {
        this.coverLetterService = coverLetterService;
        this.sendRequestListService = sendRequestListService;
    }

    //Map<Long - подразумевается что это id менеджера
    @Override
    public void sendRequest(Map<Long, List<RequestDataRow>> managerRequestDataRows) {

        //объединяем все списки в один
        List<RequestDataRow> allDataRows = new ArrayList<RequestDataRow>();
        for (List<RequestDataRow> requestDataRowList : managerRequestDataRows.values()) {
            //фильтруем по дате последнего запроса
            // т.е. те у которых после последнего запроса прошло более 30 дней
            for (RequestDataRow row : requestDataRowList) {
                if (row.getLastRequestDate().plusDays(30).isBefore(LocalDate.now())) {
                    //если оба условия совпадают то добавляем в список
                    allDataRows.addAll(requestDataRowList);
                }
            }
        }

        //группируем по банку
        Map<Long, List<RequestDataRow>> bankListMap = new HashMap<Long, List<RequestDataRow>>();
        for (RequestDataRow dataRow : allDataRows) {
            /*классический вариант
            //если в мапе нет bankid необходимо его добавить
            if (!bankListMap.containsKey(dataRow.getBankId())) {
                bankListMap.put(dataRow.getBankId(), new ArrayList<>());
            }
            //достаем элемент bankid
            bankListMap.get(dataRow.getBankId()).add(dataRow)
            */

            //вариант с использованием Stream
            bankListMap.computeIfAbsent(dataRow.getBankId(), o -> new ArrayList<>()).add(dataRow);
        }

        //создаем сопроводительные письма
        List<CoverLetter> coverLetterList = new ArrayList<CoverLetter>();
        for (Map.Entry<Long, List<RequestDataRow>> entry : bankListMap.entrySet()) {
            HashSet<ContractDto> contractDtosSet = new HashSet<>();
            coverLetterList.add(coverLetterService.createCoverLetter(entry.getKey(), contractDtosSet));

        }

        //создаем сообщения
        List<Message> messageList = new ArrayList<Message>();

        //отправляем сообщения
        sendRequestListService.sendAll(messageList);

    }

}

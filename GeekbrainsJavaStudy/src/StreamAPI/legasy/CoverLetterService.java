package StreamAPI.legasy;

import java.util.Set;

public interface CoverLetterService {
    CoverLetter createCoverLetter(Long bankId, Set<ContractDto> contractDtoSet);
}

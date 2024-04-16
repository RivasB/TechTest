package cloud.ttest.wastemanagement.wastemanageraddress.application.query.getall;

import cloud.ttest.share.core.domain.bus.query.IQuery;

public class GetAllWasteManagerAddressQuery implements IQuery {
    private final Integer pageNo;
    private final Integer pageSize;
    private final String sortBy;
    private final String sortType;

    public GetAllWasteManagerAddressQuery(Integer pageNo, Integer pageSize, String sortBy, String sortType) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.sortBy = sortBy;
        this.sortType = sortType;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getSortBy() {
        return sortBy;
    }

    public String getSortType() {
        return sortType;
    }
}

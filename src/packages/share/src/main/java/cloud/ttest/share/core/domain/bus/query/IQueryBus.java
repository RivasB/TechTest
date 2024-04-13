package cloud.ttest.share.core.domain.bus.query;

public interface IQueryBus {
    <R> R ask(IQuery query) throws QueryHandlerExecutionError;
}

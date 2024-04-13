package cloud.ttest.share.core.infrastructure.bus;

import cloud.ttest.share.core.domain.bus.command.ICommand;
import cloud.ttest.share.core.domain.bus.command.ICommandMessage;
import cloud.ttest.share.core.domain.bus.query.IQuery;
import cloud.ttest.share.core.domain.bus.query.IResponse;

public interface IMediator {
    <M extends ICommandMessage> M send(ICommand command);

    <R extends IResponse> R send(IQuery query);
}

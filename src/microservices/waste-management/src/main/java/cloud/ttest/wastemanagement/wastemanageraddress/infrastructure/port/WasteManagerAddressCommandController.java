package cloud.ttest.wastemanagement.wastemanageraddress.infrastructure.port;

import cloud.ttest.share.core.application.ApiResponse2xx;
import cloud.ttest.share.core.infrastructure.bus.IMediator;
import cloud.ttest.wastemanagement.wastemanageraddress.application.command.create.CreateWasteManagerAddressCommand;
import cloud.ttest.wastemanagement.wastemanageraddress.application.command.create.CreateWasteManagerAddressMessage;
import cloud.ttest.wastemanagement.wastemanageraddress.application.command.create.CreateWasteManagerAddressRequest;
import cloud.ttest.wastemanagement.wastemanageraddress.application.command.delete.DeleteWasteManagerAddressCommand;
import cloud.ttest.wastemanagement.wastemanageraddress.application.command.delete.DeleteWasteManagerAddressMessage;
import cloud.ttest.wastemanagement.wastemanageraddress.application.command.update.UpdateWasteManagerAddressCommand;
import cloud.ttest.wastemanagement.wastemanageraddress.application.command.update.UpdateWasteManagerAddressMessage;
import cloud.ttest.wastemanagement.wastemanageraddress.application.command.update.UpdateWasteManagerAddressRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wastemanager/address")
@Tag(name = "Command Waste Manager Address", description = " Waste Manager Address API. Contains the command " +
        "operations " +
        "that can be performed on a Waste Manager Address Entity.")
public class WasteManagerAddressCommandController {

    private final IMediator mediator;

    public WasteManagerAddressCommandController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping
    public ResponseEntity<ApiResponse2xx<CreateWasteManagerAddressMessage>> create(
            @RequestBody CreateWasteManagerAddressRequest request) {
        CreateWasteManagerAddressCommand createCommand = new CreateWasteManagerAddressCommand(request);
        CreateWasteManagerAddressMessage response = mediator.send(createCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @PutMapping
    public ResponseEntity<ApiResponse2xx<UpdateWasteManagerAddressMessage>> update(
            @RequestBody UpdateWasteManagerAddressRequest request) {
        UpdateWasteManagerAddressCommand updateCommand = new UpdateWasteManagerAddressCommand(request);
        UpdateWasteManagerAddressMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse2xx<DeleteWasteManagerAddressMessage>> update(
            @NotBlank @PathVariable("id") Long id) {
        DeleteWasteManagerAddressCommand updateCommand = new DeleteWasteManagerAddressCommand(id);
        DeleteWasteManagerAddressMessage response = mediator.send(updateCommand);
        return ResponseEntity.ok(new ApiResponse2xx<>(response, HttpStatus.NO_CONTENT));
    }



}

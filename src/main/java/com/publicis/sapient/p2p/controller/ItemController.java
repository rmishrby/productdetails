package com.publicis.sapient.p2p.controller;

import com.publicis.sapient.p2p.entity.Item;
import com.publicis.sapient.p2p.service.ItemService;
import com.publicis.sapient.p2p.vo.ServiceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@Tag(name = "Item", description = "Product Service API for getting item information")
public class ItemController {
    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @Operation(operationId = "getItemDetails", description = "Get Item Details with item id", summary = "This endpoint gives item details with given item id with separated with ,", tags = {"Item"},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Fetched Items Successfully", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Item.class)))),
                    @ApiResponse(responseCode = "404", description = "Item Not Found", content = @Content(schema = @Schema(implementation = ServiceResponse.class))),
            })
    @GetMapping(value = "/item")
    public List<Item> getItemDetails(@RequestParam String id){
        logger.info("Entering getItemDetails method with endpoint: /item");
        List<String> ids = Arrays.asList(id.split(","));
        List<Item> items = new ArrayList<>();
        ids.forEach(itemId -> items.add(itemService.getItemDetails(itemId)));
        return items;
    }
}
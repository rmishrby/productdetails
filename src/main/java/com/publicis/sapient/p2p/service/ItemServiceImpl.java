package com.publicis.sapient.p2p.service;

import com.publicis.sapient.p2p.exception.BusinessException;
import com.publicis.sapient.p2p.exception.util.ErrorCode;
import com.publicis.sapient.p2p.exception.util.ErrorResolver;
import com.publicis.sapient.p2p.entity.Item;
import com.publicis.sapient.p2p.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class ItemServiceImpl implements ItemService {
    private final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
    @Autowired
    ErrorResolver errorResolver;
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public Item getItemDetails(String itemId) {
        logger.info("Entering getItemDetails method inside ItemServiceImpl");
        return  itemRepository.findById(itemId).orElseThrow(()-> {
            logger.error(MessageFormat.format("Item not found with id : {0}", itemId));
            return new BusinessException(ErrorCode.NOT_FOUND, errorResolver.getErrorMessage("ERR_DETAIL_NOT_FOUND", "Item not found with id : "+itemId));
        });
    }
}

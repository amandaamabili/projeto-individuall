package com.desafiofinal.praticafinal.service;

import com.desafiofinal.praticafinal.dto.BatchStockDTO;
import com.desafiofinal.praticafinal.exception.ElementNotFoundException;
import com.desafiofinal.praticafinal.exception.ElementeAlreadyExistsException;
import com.desafiofinal.praticafinal.dto.InboundOrderRequestDTO;
import com.desafiofinal.praticafinal.model.*;
import com.desafiofinal.praticafinal.dto.InBoundOrderResponseDTO;
import com.desafiofinal.praticafinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InBoundOrderImpService implements IinBoundOrderService {

    @Autowired
    private InBoundOrderRepo inBoundOrderRepo;

    @Autowired
    private IBatchStockRepo batchStockRepo;

    @Autowired
    private ISectorRepo sectorRepo;

    @Autowired
    private IWareHouseRepo wareHouseRepo;

    @Autowired
    private IManagerRepo managerRepo;

    @Autowired
    private IProductRepo productRepo;

    @Autowired
    private ISellerRepo sellerRepo;

    @Transactional
    public InBoundOrderResponseDTO saveInBoundOrder (InboundOrderRequestDTO inboundOrderRequestDTO) throws Exception {
        InBoundOrder inBoundOrder = convertToInBoundOrder(inboundOrderRequestDTO);

        Optional<InBoundOrder> foundInBoundOrder = inBoundOrderRepo.findById(inBoundOrder.getOrderId());

        //TODO USAR DEPOIS UM TERNARIO
        if(foundInBoundOrder.isPresent()){
            throw new ElementeAlreadyExistsException("In bound order already exists");
        }else {
            InBoundOrder savedInBoundOrder = inBoundOrderRepo.save(inBoundOrder);
            return new InBoundOrderResponseDTO(savedInBoundOrder);
        }
    }

    public InBoundOrderResponseDTO updateInBoundOrder (InboundOrderRequestDTO inBoundOrderRequestDto) throws Exception {

        InBoundOrder inBoundOrder = convertToInBoundOrder(inBoundOrderRequestDto);

        Optional<InBoundOrder> foundInBoundOrder = inBoundOrderRepo.findById(inBoundOrderRequestDto.getOrderId());
        //TODO USAR DEPOIS UM TERNARIO
        if(foundInBoundOrder.isPresent()){

            batchStockRepo.saveAll(inBoundOrder.getBatchStockList());
            InBoundOrder updatedInBoundOrder = inBoundOrderRepo.save(inBoundOrder);
            return new InBoundOrderResponseDTO(updatedInBoundOrder);

        }else {
            throw new ElementNotFoundException("In bound order does not exists");
        }

//        List<BatchStock> tempBatchList = new ArrayList();
//
//        for(BatchStock batchStock : newUpdatedInBoundOrder.getBatchStockList()){
//
//            tempBatchList.add(batchStock);
//        }
//
//        for(BatchStock responseStock : tempBatchList)
//        {
//            Optional<BatchStock> foundBatch = batchStockRepo.findById(responseStock.getBatchId());
//            if(foundBatch.isPresent())
//            {
//                if ((foundBatch.get().getInBoundOrder().getOrderId()== newUpdatedInBoundOrder.getOrderId())){
//                    responseStock.setInBoundOrder(newUpdatedInBoundOrder);
//                    batchStockRepo.save(responseStock);
//                }else {
//                    throw new Exception("O batchStock não pertence ao inBoundOrder");
//                }
//
//            }
//            else
//            {
//                throw new Exception("Este Batch não existe");
//            }
//        }

    }

//    public InBoundOrderResponseDto inBoundOrderGetPrice (InBoundOrderRequestDto inBoundOrderRequestDto) {
//        InBoundOrder newInBoundOrder = InBoundOrderRequestDto.convertDtoToInBoundOrder(inBoundOrderRequestDto);
//
//        for (BatchStock batchStockProduct: newInBoundOrder.getBatchStockList()){
//            batchStockProduct.getProduct().getPrice();
//        }
//    }

    private InBoundOrder convertToInBoundOrder(InboundOrderRequestDTO inboundOrderRequestDTO) {
        InBoundOrder inboundOrder = new InBoundOrder();
        Optional<InBoundOrder> foundInBundOrder = inBoundOrderRepo.findById(inboundOrderRequestDTO.getOrderId());
        if(foundInBundOrder.isPresent()){
            inboundOrder.setOrderId(foundInBundOrder.get().getOrderId());

        } else{
            inboundOrder.setOrderId(0L);
        }
        var sectorID = inboundOrderRequestDTO.getSector().getSectorId();
        verifySector(inboundOrder, sectorID);

        var batchList = inboundOrderRequestDTO.getBatchStockList().stream().map(dto -> {
            Product product = verifyProduct(dto);

            return  new BatchStock(
                    dto.getBatchNumber(),
                    dto.getCurrentTemperature(),
                    dto.getMinimumTemperature(),
                    dto.getInitialQuantity(),
                    dto.getCurrentQuantity(),
                    dto.getManufacturingDate(),
                    dto.getManufacturingTime(),
                    dto.getDueDate(),
                    inboundOrder,
                    product);
        }).collect(Collectors.toList());

        inboundOrder.setBatchStockList(batchList);

        return inboundOrder;
    }

    private void verifySector(InBoundOrder inboundOrder, long sectorID) {
        Optional<Sector> foundSector = sectorRepo.findById(sectorID);

        if(foundSector.isPresent()){
            inboundOrder.setSector(foundSector.get());
        }else{
            throw new ElementNotFoundException("Sector does not exists");
        }
    }

    private Product verifyProduct(BatchStockDTO batchStockDTO) {
        Optional<Product> foundProduct = productRepo.findById(batchStockDTO.getProduct());
        if (foundProduct.isPresent()){
            return foundProduct.get();
        } else {
            throw new ElementNotFoundException("Product does ot exists");
        }
    }
}



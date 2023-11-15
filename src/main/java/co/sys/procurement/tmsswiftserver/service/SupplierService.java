package co.sys.procurement.tmsswiftserver.service;

import co.sys.procurement.tmsswiftserver.dto.ResponseDto;
import co.sys.procurement.tmsswiftserver.dto.SupplierQuotationDto;

import java.text.ParseException;

public interface SupplierService {
    ResponseDto saveQuotation(SupplierQuotationDto quotationDto) throws ParseException;
    ResponseDto getQuotation(SupplierQuotationDto quotationDto);
}

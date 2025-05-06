package org.example.parking.repository.ticket;

import org.example.parking.model.TicketModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TicketRepo {

   private HashMap<String, String> ticketMap = new HashMap<>();
   private List<TicketModel> ticketModelList =  new ArrayList<>();

   public void addtoMap(String ticketId, String parkingId){
       ticketMap.put(ticketId,parkingId);
   }

   public void ticketToList(TicketModel ticketModel){
       ticketModelList.add(ticketModel);
   }

   public TicketModel fetchTicket(String id){
       for (TicketModel ticket : ticketModelList) {
           if (id.equals(ticket.getIssuedAt())) {
               return ticket;
           }
       }
       return null;
   }

}


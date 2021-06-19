package com.laioffer.eco.config;

import com.laioffer.eco.model.*;
import com.laioffer.eco.repository.*;
import com.laioffer.eco.util.AgentStatus;
import com.laioffer.eco.util.AgentType;
import com.laioffer.eco.util.CenterID;
import com.laioffer.eco.util.OrderStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class AllConfig {

   // private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//    @Bean
//    CommandLineRunner orderRunner(AccountRepository accountRepository,
//                                  SenderRepository senderRepository,
//                                  RecipientRepository recipientRepository,
//                                  ItemRepository itemRepository,
//                                  EcoOrderRepository ecoOrderRepository,
//                                  DispatchCenterRepository dispatchCenterRepository,
//                                  AgentRepository agentRepository) {
//
//        //LocalDateTime orderTime =  LocalDateTime.parse("2021-6-1 10:00:00", FORMATTER);
//        //DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a (zzz)");
//        //ZoneId zoneId = ZoneId.of( "America/Los_Angeles" );
//        return args -> {
//
//            Sender sender1= new Sender("Tom", "Cruise", "1201 Funston Ave, San Francisco, CA 94122",
//                    "111-222-3333", "tc@gmail.com");
//            Sender sender2= new Sender("Angelina", "Jolie", "2193 Fillmore St, San Francisco, CA 94115",
//                    "999-888-7777", "aj@gmail.com");
//            Recipient recipient1= new Recipient("Chris", "Pratt", "1010 16th St, San Francisco, CA 94107",
//                    "222-333-4444", "cp@gmail.com");
//            Recipient recipient2= new Recipient("Natasha", "Poly", "88 Hillside Blvd, Daly City, CA 94014",
//                    "333-444-5555", "np@gmail.com");
//
//            Item item1 = new Item(10, true, "bottle", 1);
//            Item item2 = new Item(1, false, "document", 5);
//
//
//            EcoOrder order1 = new EcoOrder(
//                    "11 St",
//                    "22 St",
//                    OrderStatus.PLACED,
//                    CenterID.CENTER_0,
//                    AgentType.ROBOT,
//                    LocalDateTime.parse("2021-06-01T10:00:00"),
//                    LocalDateTime.parse("2021-06-02T10:00:00"),
//                    LocalDateTime.parse("2021-06-05T10:00:00")
//            );
//            EcoOrder order2 = new EcoOrder(
//                    "22 St",
//                    "33 St",
//                    OrderStatus.PICKED,
//                    CenterID.CENTER_0,
//                    AgentType.DRONE,
//                    LocalDateTime.parse("2021-06-01T10:00:00"),
//                    LocalDateTime.parse("2021-06-01T11:00:00"),
//                    LocalDateTime.parse("2021-06-02T10:00:00")
//            );
//            EcoOrder order3 = new EcoOrder(
//                    "55 St",
//                    "66 St",
//                    OrderStatus.COMPLETED,
//                    CenterID.CENTER_1,
//                    AgentType.ROBOT,
//                    LocalDateTime.parse("2021-06-01T10:00:00"),
//                    LocalDateTime.parse("2021-06-01T11:00:00"),
//                    LocalDateTime.parse("2021-06-02T10:00:00")
//            );
//            EcoOrder order4 = new EcoOrder(
//                    "00 St",
//                    "00 St",
//                    OrderStatus.CANCELED,
//                    CenterID.CENTER_2,
//                    AgentType.ROBOT,
//                    LocalDateTime.parse("2021-06-01T10:00:00"),
//                    LocalDateTime.parse("2021-06-01T11:00:00"),
//                    LocalDateTime.parse("2021-06-02T10:00:00")
//            );
//
//
//
//            order1.setSender(sender1);
//            order1.setRecipient(recipient1);
//            order1.setItem(item1);
//
//            order2.setSender(sender2);
//            order2.setRecipient(recipient2);
//            order2.setItem(item2);
//
//
//
//
//            DispatchCenter dispatchCenter_1 = new DispatchCenter(CenterID.CENTER_0, "1802 Balboa St, San Francisco, CA 94121", 10, 20, 10, 20, 37.776760,-122.478300);
//            DispatchCenter dispatchCenter_2 = new DispatchCenter(CenterID.CENTER_1, "4705 3rd St, San Francisco, CA 94124", 10, 20, 10, 20, 37.735130, -122.390442);
//            DispatchCenter dispatchCenter_3 = new DispatchCenter(CenterID.CENTER_2, "302 Randolph St, San Francisco, CA 94132", 10, 20, 10, 20, 37.714320, -122.465330);
//
//            //Agent robot1 = new Agent(AgentType.ROBOT, AgentStatus.IN_USE);
//            //Agent drone1 = new Agent(AgentType.DRONE, AgentStatus.AVAILABLE);
//
//            //Set<Agent> agents = new HashSet<>();
//            //agents.add(robot1);
//            //agents.add(drone1);
//            //dispatchCenter.setAgents(agents);
//            //robot1.setCenter(dispatchCenter);
//            //drone1.setCenter(dispatchCenter);
//
//            //order1.setAgent(drone1);
//            //drone1.setOrder(order1);
//            //order2.setAgent(robot1);
//            //robot1.setOrder(order2);
//
//            Account jiayu = new Account.Builder()
//                    .firstName("Jiayu")
//                    .lastName("Li")
//                    .email("jiayu@a.com")
//                    .password("123456")
//                    .address("181 Sanchez St, San Francisco")
//                    .zipcode(94114)
//                    .phone("212-111-1111")
//                    .build();
//
//            Account liangGao = new Account.Builder()
//                    .firstName("Liang")
//                    .lastName("Gao")
//                    .email("lg@depaul.edu")
//                    .password("123456")
//                    .address("296A Addison St, San Francisco")
//                    .zipcode(94131)
//                    .phone("212-222-2222")
//                    .build();
//
//
//            Set<EcoOrder> orders = new HashSet<>();
//            orders.add(order1);
//            orders.add(order2);
//            dispatchCenter_1.setCurrentDroneAmount(9);
//            dispatchCenter_1.setCurrentRobotAmount(19);
//            orders.add(order3);
//            dispatchCenter_2.setCurrentRobotAmount(19);
//            orders.add(order4);
//            dispatchCenter_3.setCurrentRobotAmount(19);
//
//            jiayu.setEcoOrders(orders);
//            order1.setAccount(jiayu);
//            order2.setAccount(jiayu);
//            order3.setAccount(jiayu);
//            order4.setAccount(jiayu);
//
//            senderRepository.saveAll(Arrays.asList(sender1, sender2));
//            recipientRepository.saveAll(Arrays.asList(recipient1, recipient2));
//            itemRepository.saveAll(Arrays.asList(item1, item2));
//            ecoOrderRepository.saveAll(Arrays.asList(order1, order2));
//            dispatchCenterRepository.saveAll(Arrays.asList(dispatchCenter_1, dispatchCenter_2, dispatchCenter_3));
//            accountRepository.saveAll(Arrays.asList(jiayu, liangGao));
//
//            // Java 16
//            /*
//            senderRepository.saveAll(List.of(sender1, sender2));
//            recipientRepository.saveAll(List.of(recipient1, recipient2));
//            itemRepository.saveAll(List.of(item1, item2));
//            ecoOrderRepository.saveAll(List.of(order1, order2));
//            dispatchCenterRepository.saveAll(List.of(dispatchCenter_1, dispatchCenter_2, dispatchCenter_3));
//            //agentRepository.saveAll(List.of(robot1, drone1));
//            accountRepository.saveAll(List.of(jiayu));
//             */
//        };
//    }

    @Bean
    CommandLineRunner orderRunner(EcoOrderRepository ecoOrderRepository,
                                  DispatchCenterRepository dispatchCenterRepository) {
        return args -> {

            //sender
            Sender sender1= new Sender(
                    "Tom",
                    "Cruise",
                    "1111 S Chicago Ave",
                    "111-222-3333",
                    "tc@gmail.com");

            Sender sender2= new Sender(
                    "Angelina",
                    "Jolie",
                    "9999 N NYC Dr",
                    "999-888-7777",
                    "aj@gmail.com");

            //recipient
            Recipient recipient1= new Recipient(
                    "Chris",
                    "Pratt",
                    "2222 S Indiana Ave",
                    "222-333-4444",
                    "cp@gmail.com");

            Recipient recipient2= new Recipient("Natasha",
                    "Poly",
                    "5555 S Wisconsin St",
                    "333-444-5555",
                    "np@gmail.com");

            //centers
            DispatchCenter dispatchCenter_1 = new DispatchCenter(
                    CenterID.CENTER_0,
                    "1802 Balboa St, San Francisco, CA 94121",
                    10,
                    20,
                    10,
                    20,
                    37.776760,
                    -122.478300);
            DispatchCenter dispatchCenter_2 = new DispatchCenter(
                    CenterID.CENTER_1,
                    "4705 3rd St, San Francisco, CA 94124",
                    10,
                    20,
                    10,
                    20,
                    37.735130,
                    -122.390442);

            DispatchCenter dispatchCenter_3 = new DispatchCenter(
                    CenterID.CENTER_2,
                    "302 Randolph St, San Francisco, CA 94132",
                    10,
                    20,
                    10,
                    20,
                    37.714320,
                    -122.465330);


            //item
            Item item1 = new Item(10, true, "bottle", 1);
            Item item2 = new Item(1, false, "document", 5);

            //account
            Account account1 = new Account(
                    "az@gmail.com",
                    "123",
                    "alan",
                    "zhu",
                    "212-111-1111",
                    "San Francisco",
                    60600,
                    300,
                    "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhekBnbWFpbC5jb20iLCJleHAiOjE2MjMyMzg2MzIsImlhdCI6MTYyMzIyMDYzMn0.JdXqDCsQiWEFD5WYDW9efIwNlSbkKOKSkL0jdXxV5po9W3p5jDTGlZO-dvOY0uLIj3wo41-6wE6ZvOtkIm-b7w"
            );

            //order
            EcoOrder ecoOrder = new EcoOrder(
                    "11 St", 41.868410, -87.624628,
                    "22 St", 41.924759, -87.655656,
                    OrderStatus.PLACED,
                    LocalDateTime.parse("2021-06-01T10:00:00"),
                    LocalDateTime.parse("2021-06-01T10:10:00"),
                    LocalDateTime.parse("2021-06-01T10:30:00"),
                    12.99,
                    CenterID.CENTER_1,
                    AgentType.ROBOT,
                    sender1,
                    recipient1,
                    item1,
                    account1,
                    false);



            ecoOrderRepository.save(ecoOrder);
            dispatchCenterRepository.saveAll(Arrays.asList(dispatchCenter_1, dispatchCenter_2, dispatchCenter_3));
        };
    }

}


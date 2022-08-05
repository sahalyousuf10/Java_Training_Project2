package com.sahal.JavaTrainingProject2.service;

import com.sahal.JavaTrainingProject2.model.User;
import com.sahal.JavaTrainingProject2.model.Bank;
import com.sahal.JavaTrainingProject2.model.Bank_User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Slf4j
@Service
public class DataService {

    private static final String FILE_1_PATH = "/Users/msahal/Documents/workspace/File1.txt";
    private static final String FILE_2_PATH = "/Users/msahal/Documents/workspace/File2.txt";
    private static final String FILE_3_PATH = "/Users/msahal/Documents/workspace/File3.txt";

    public String saveUserData(User file1) throws Exception {
        try {
            FileWriter fw1 = new FileWriter(FILE_1_PATH, true);
            fw1.append(file1.getId().toString() + "," + file1.getName() + "," + file1.getAge() + "," + file1.getProfession() + "," + file1.getMaritialStatus()+"\n");
            fw1.close();
            return "User data saved successfully!";
        } catch (Exception ex) {
            log.error("Exception caught:"+ex.getMessage());
            throw ex;
        }
    }

    public String saveBankData(Bank file2) throws Exception {
        try {
            FileWriter fw1 = new FileWriter(FILE_2_PATH);
            fw1.append(file2.getId() + "," + file2.getBankName() + "," + file2.getAccountNumber() + "," + file2.getCreditCardStatus()+"\n");
            fw1.close();
            return "Bank data saved successfully!";
        } catch (Exception ex) {
            log.error("Exception caught:"+ex.getMessage());
            throw ex;
        }
    }

    public String saveDataInFile3() throws IOException {

        try {
            BufferedReader br1;
            BufferedReader br2;
            BufferedWriter bw;

            String line1;
            String line2;

            br1 = new BufferedReader(new FileReader(FILE_1_PATH));
            br2 = new BufferedReader(new FileReader(FILE_2_PATH));
            bw = new BufferedWriter(new FileWriter(FILE_3_PATH));

            Map<Long, List<String>> map1 = new HashMap<>();
            Map<Long, List<String>> map2 = new HashMap<>();

            line1 = br1.readLine();
            while (line1 != null) {
                List<String> list1;
                list1 = Arrays.asList(line1.split(","));
                long id1 = Long.parseLong(list1.get(0)); //key
                List<String> values = list1.subList(1, list1.size());
                map1.put(id1, values);
                line1 = br1.readLine();
            }

            line2 = br2.readLine();
            while (line2 != null) {
                List<String> list2;
                list2 = Arrays.asList(line2.split(","));
                long id2 = Long.parseLong(list2.get(0)); //key
                List<String> values = list2.subList(1, list2.size()); //value
                map2.put(id2, values);
                line2 = br2.readLine();
            }

            Set<Long> keySet = map1.keySet();
            for (Long k : keySet) {
                List<String> values1 = map1.get(k);
                List<String> values2 = map2.get(k);
                String lineWrite = k + values1.toString() + values2.toString();
                lineWrite = lineWrite.replaceAll("\\[", ", ").replaceAll("\\]", "");
                bw.append(lineWrite);
                bw.append("\n");
            }
            bw.close();
            return "Data saved successfully!";
        }
        catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw ex;
        }
    }

    public List<Bank_User> getAllUsers() throws IOException {

        List<Bank_User> file3List = new ArrayList<>();
        BufferedReader br;
        String line1;

        try {
            br = new BufferedReader(new FileReader(FILE_3_PATH));
            line1 = br.readLine();
            while (line1 != null) {
                List<String> list1;
                list1 = Arrays.asList(line1.split(", "));
                Bank_User file3 = new Bank_User();
                file3.setId(Long.valueOf(list1.get(0)));
                file3.setName(list1.get(1));
                file3.setAge(Integer.parseInt(list1.get(2)));
                file3.setProfession(list1.get(3));
                file3.setMaritialStatus(list1.get(4));
                file3.setBankName(list1.get(5));
                file3.setAccountNumber(Long.valueOf(list1.get(6)));
                file3.setCreditCardStatus(list1.get(7));
                file3List.add(file3);
                line1 = br.readLine();
            }
            br.close();
            return file3List;
        }
        catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw ex;
        }
    }

    public Bank_User getUserWithId(Long id) throws IOException {

        Bank_User file3 = new Bank_User();
        BufferedReader br ;
        String line1;

        try {
            br = new BufferedReader(new FileReader(FILE_3_PATH));
            line1 = br.readLine();
            while (line1 != null) {
                List<String> list1;
                list1 = Arrays.asList(line1.split(", "));
                if (list1.get(0).equals(id.toString())) {
                    file3.setId(Long.valueOf(list1.get(0)));
                    file3.setName(list1.get(1));
                    file3.setAge(Integer.parseInt(list1.get(2)));
                    file3.setProfession(list1.get(3));
                    file3.setMaritialStatus(list1.get(4));
                    file3.setBankName(list1.get(5));
                    file3.setAccountNumber(Long.valueOf(list1.get(6)));
                    file3.setCreditCardStatus(list1.get(7));
                    break;
                }
                line1 = br.readLine();
            }
            br.close();
            return file3;
        }
        catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw ex;
        }
    }

    public String updateCCStatus(Long id, String status) throws Exception {

        List<Bank_User> file3List = new ArrayList<>();
        BufferedWriter bw;
        BufferedReader br;
        String line1;

        try {
            br = new BufferedReader(new FileReader(FILE_3_PATH));
            line1 = br.readLine();
            while (line1 != null) {
                List<String> list1;
                list1 = Arrays.asList(line1.split(", "));
                if (list1.get(0).equals(id.toString())) {
                    if (list1.get(3).equals("Banker") || list1.get(3).equals("Business")) {
                        Bank_User file3 = new Bank_User();
                        file3.setId(Long.valueOf(list1.get(0)));
                        file3.setName(list1.get(1));
                        file3.setAge(Integer.parseInt(list1.get(2)));
                        file3.setProfession(list1.get(3));
                        file3.setMaritialStatus(list1.get(4));
                        file3.setBankName(list1.get(5));
                        file3.setAccountNumber(Long.valueOf(list1.get(6)));
                        file3.setCreditCardStatus(status);
                        file3List.add(file3);
                    }
                }
                else {
                    Bank_User file3 = new Bank_User();
                    file3.setId(Long.valueOf(list1.get(0)));
                    file3.setName(list1.get(1));
                    file3.setAge(Integer.parseInt(list1.get(2)));
                    file3.setProfession(list1.get(3));
                    file3.setMaritialStatus(list1.get(4));
                    file3.setBankName(list1.get(5));
                    file3.setAccountNumber(Long.valueOf(list1.get(6)));
                    file3.setCreditCardStatus(list1.get(7));
                    file3List.add(file3);
                }
                line1 = br.readLine();
            }
            br.close();

            bw = new BufferedWriter(new FileWriter(FILE_3_PATH));
            file3List.forEach(l -> {
                try {
                    bw.write(l.toString());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            bw.close();
            return "Credit card status of user "+id+" is updated to "+status;
        }
        catch (Exception ex) {
            log.error("Exception caught: "+ex.getMessage());
            throw ex;
        }
    }
}

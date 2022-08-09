package com.example.hw2restfulsanta.service;

import com.example.hw2restfulsanta.model.Kid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KidService {
    private List<Kid> kidList;

    public KidService() {
        //3筆測試用假資料
        this.kidList = new ArrayList<>();
        this.kidList.add(new Kid(1, 5, "Abby", "aCity", "Aliens"));
        this.kidList.add(new Kid(2, 6, "Bob", "bCity", "Buzz Lightyear"));
        this.kidList.add(new Kid(3, 7, "Chris", "cCity", "Forky"));
    }

    /**
     * 取得所有小朋友
     * @return kidList
     */
    public List<Kid> getAllKids() {
        return this.kidList;
    }

    /**
     * 根據 id 取得該小朋友資料
     * @param id
     * @return Kid 小朋友資料
     */
    public Kid getKidById(int id) {
        for (Kid kid : this.kidList) {
            if (id == kid.getId()) {
                return kid;
            }
        }
        return null;
    }

    /**
     * 新增小朋友至清單
     * 大於等於18、id重複、(地址、年紀及名字)重複 無法新增 並拋出Exception
     * @param kid
     * @return Kid 新增的小朋友資料
     * @throws Exception
     */
    public Kid createKid(Kid kid) throws Exception {
        for(Kid k : this.kidList){
            if(kid.getAge() >= 18){
                throw new Exception("This guy is not a kid anymore! ");
            }
            if(k.getId() == kid.getId()){
                throw new Exception("This ID is not available, please change it!");
            }
            if(k.getAddress().equals(kid.getAddress()) && k.getAge() == kid.getAge()
                    && k.getName().equals(kid.getName()) ){
                throw new Exception("same kid cannot receive more than 1 gift!");
            }
        }

        this.kidList.add(kid);
        return kid;
    }

    /**
     * 根據id 取得小朋友資料並修改
     * @param id
     * @param kid
     * @return Kid 修改過後的小朋友資料
     */
    public Kid updateKid(int id, Kid kid) {
        for (Kid kidFromList : this.kidList) {
            if (id == kidFromList.getId()) {
                kidFromList.setAge(kid.getAge());
                kidFromList.setName(kid.getName());
                kidFromList.setAddress(kid.getAddress());
                kidFromList.setGift(kid.getGift());
                return kid;
            }
        }
        return null;
    }

    /**
     * 根據id 從清單中刪除該小朋友
     * @param id
     * @return Kid 刪掉的小朋友
     */
    public Kid deleteKid(int id) {
        for (Kid kid : this.kidList) {
            if (id == kid.getId()) {
                this.kidList.remove(kid);
                return kid;
            }
        }
        return null;
    }

}

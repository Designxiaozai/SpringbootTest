package com.ljm.Trow;


import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class yichang {
    private Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());
    @GetMapping("/throw")
    public  void  test(){
        try {
            throw  new Exception("test");
        } catch (Exception e) {
            log.error("");
            e.printStackTrace();
        }
    }

//        public void  test2() throws Exception {
//        throw new Exception("test");
//        }

}

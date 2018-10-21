package sk.stopangin.spring.aspectj.service;

import org.springframework.stereotype.Service;

@Service
public class MagicServic {
    public void doMageic() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
                    }
        System.out.println("Something magical");
    }
}

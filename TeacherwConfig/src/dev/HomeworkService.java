package dev;

import org.springframework.stereotype.Component;

@Component
public class HomeworkService {

        private String message = "Learn more";

        public void setHomework(String message) {
            this.message = message;
        }

        public String getHomework() {
            return message;
        }


}

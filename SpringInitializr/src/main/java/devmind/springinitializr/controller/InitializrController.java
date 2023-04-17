package devmind.springinitializr.controller;

import devmind.springinitializr.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class InitializrController {
    TimeService timeService = new TimeService();
    @Autowired
    HPService harryp;


    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String time(@RequestParam("timeZone") String timeZone){
        return timeService.getTime(timeZone);
    }

    @RequestMapping(value = "/harry-potter", method = RequestMethod.GET)
    public String character(){
        return harryp.getRandomCharacter();
    }

    @RequestMapping(value = "/math-service", method = RequestMethod.POST)
    public ResponseEntity<Result> calculate(@RequestBody MathService mathService) {

        if (mathService.getSecondNumber() == 0 && mathService.getOperation().equalsIgnoreCase("divide")) {
            return new ResponseEntity<Result>((Result) null, HttpStatus.resolve(400));
        }
        if(Operation.valueOfLabel(mathService.getOperation()) == null) {
            return new ResponseEntity<Result>((Result) null, HttpStatus.resolve(401));
        }

        int result = mathService.calculate();
        HttpStatus status = HttpStatus.OK;
        Result r = new Result();
        r.setResult(result);
        return new ResponseEntity<>(r, status);

    }

}

import { useState, useEffect} from "react";
const Stopwatch = () => {
    const [time, setTime] = useState("00:00:00");
    const [isRunning, setIsRunning] = useState(true);
    let hours;
    let minutes;
    let seconds;
    let nIntervalID;

    useEffect(() => {
        console.log(`initializing interval`);
        return () => {
            clearInterval(nIntervalID);
        };
    },[isRunning]);
    const changeTimer = () => {
        if(seconds == 59) {
            seconds = 0;
            if(minutes == 59) {
                minutes = 0;
                hours = hours + 1;
            } else {
                minutes = minutes + 1;
            }
        } else {
            seconds = seconds + 1;
        }
        let auxH = (hours <= 9 ? "0"+hours : hours);
        let auxM = (minutes <= 9 ? "0"+minutes : minutes);
        let auxS = (seconds <= 9 ? "0"+seconds : seconds);
        setTime(auxH + ":" + auxM + ":" + auxS);
    }
    const startTimer = () => {
        setIsRunning(true);
        minutes = 0;
        seconds = 0;
        hours = 0;
        nIntervalID = setInterval(() => {
            changeTimer();
        }, 1000);

    };

    const stopTimer = () => {
        console.log("clearing interval");
        setIsRunning(false);

    };
    return (
        <div>
            <h1>{time}</h1>
            <button className="myButtons" onClick={startTimer}>Start</button>
            <button className="myButtons" onClick={stopTimer}>Stop</button>
        </div>

    );

};

export default Stopwatch;
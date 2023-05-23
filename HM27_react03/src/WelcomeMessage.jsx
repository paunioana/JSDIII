import { useState, useEffect} from "react";

const WelcomeMessage = () => {
    const [message, setMessage] = useState("Please wait...");
    useEffect(() => {
        setTimeout(() => {
            setMessage("Welcome to Devmind!")
    },3000);
    }, []);
    return (
        <div>
            <h1>{message}</h1>
        </div>

    );

};

export default WelcomeMessage;
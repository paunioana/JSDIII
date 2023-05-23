import { useState, useEffect } from "react";
const Counter = () => {
    const [count, setCount] = useState(0);

    const increment = () => {
        setCount(count => count + 1);
        console.log("Counter value:", count + 1);
    };

    const decrement = () => {
        setCount(count => count - 1);
        console.log("Counter value:", count - 1);
    };

    useEffect(() => {
        console.log("Counter component rendered");
    }, []);



    return (
        <div>
            <h2>This is my homework counter</h2>
            <button className="myButtons" onClick={decrement}>-</button>
            <span>{count}</span>
            <button className="myButtons" onClick={increment}>+</button>
        </div>
    );
}

export default Counter;
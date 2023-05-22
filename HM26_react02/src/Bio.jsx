const Bio = (props) => {
    return (<div className="bio">
            <p>{props.birthDate}</p>
            <p>{props.description}</p>
        <p>{"Programmer: " +(props.hobbies.indexOf("Java") !== -1 || props.hobbies.indexOf("React") !== -1)}</p>
        </div>
    );
};
export default Bio;
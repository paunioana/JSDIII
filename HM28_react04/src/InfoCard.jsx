import "./InfoCard.css";
const InfoCard = (props) => {
    const description = props.description;
    const image = props.image;
    const question = props.question;
    const separatorClass = props.separatorClass;
    return(
        <div className="card-container">
            <img className="potato" src={image}/>
            <span className="question">{question}</span>
            <div className={`separator ${separatorClass}`}/>
            <span className="description">{description}</span>
        </div>
    );
};
export default InfoCard;
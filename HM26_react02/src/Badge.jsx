import Bio from "./Bio.jsx";
import React from "react";
class Badge extends React.Component {
    render() {
        const { firstName, lastName, description, birthDate, hobbies, avatarImage} = this.props;
       return (
           <div className="badge">
            <img
                src={avatarImage}
                height="64px"
            />
            <h4>{firstName}</h4>
            <h4>{lastName}</h4>
            <Bio birthDate={birthDate}
                 description={description}
                 hobbies={hobbies}/>
        </div>
       )

    }
};

export default Badge;
import React from "react";
import './App.css'
import LogoComponent from "./LogoComponent.jsx";
import Badge from "./Badge.jsx";



const badges = [
    {
        firstName: "Johhny",
        lastName: "Depp",
        img: "http://placekitten.com/g/64/64",
        // img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIMJf32XCdIMPR005aLZbkk5TldBubjW2CfA&usqp=CAU",
        hobbies: "running",
        birthDate: "13/03/2014",
        description: "tomberonesse imperialle"
    },
    {
        firstName: "Tommy",
        lastName: "Williams",
        img: "http://placekitten.com/64/65",
        // img: "https://thumbs.dreamstime.com/b/default-avatar-photo-placeholder-profile-icon-eps-file-easy-to-edit-default-avatar-photo-placeholder-profile-icon-124557887.jpg",
        hobbies: 'siaviata',
        birthDate: "13/12/2021",
        description: "washed european"
    },
    {
        firstName: "Blanita",
        lastName: "Buzdugan",
        img: "http://placekitten.com/65/64",
        // img: "https://thumbs.dreamstime.com/b/default-avatar-photo-placeholder-profile-icon-eps-file-easy-to-edit-default-avatar-photo-placeholder-profile-icon-124557887.jpg",
        hobbies: "carti, Java",
        birthDate: "12/04/2014",
        description: "europeana tarcata"
    }
];

class App extends React.Component {
    constructor() {
        super();
        this.state = {
            counterValue: 0,
        };
    }

    render() {
        const counterValueText = "First counter value " + this.state.counterValue;
        return (
            <div id="container">
                <LogoComponent/>
                <div>
                    <button className="counterButton"
                        onClick={(event) => {
                            this.setState((state, props) => {
                                return {
                                    counterValue: state.counterValue - 1,
                                };
                            });
                        }}
                    >
                        -
                    </button>
                    <span>{"  "+counterValueText+"  "}</span>
                    <button
                        onClick={(event) => {
                            this.setState((state, props) => {
                                return {
                                    counterValue: state.counterValue + 1,
                                };
                            });
                        }}
                    >
                        +
                    </button>
                </div>
                <button
                    onClick={(event) => {
                        this.setState({counterValue: 0});
                    }}
                >
                    Reset counter
                </button>
                <div className="badgeContainer">
                    {badges.map( e => (
                        <Badge
                            firstName={e.firstName}
                            lastName={e.lastName}
                            avatarImage={e.img}
                            birthDate={e.birthDate}
                            description={e.description}
                            hobbies={e.hobbies}/>

                        )
                        )
                    }
                </div>
            </div>


        );
    }
}

export default App;
import Box from "@mui/material/Box";

const InfoCardMUI = (props) => {
    // eslint-disable-next-line react/prop-types
    const description = props.description;
    const MaterialIcon = props.image;
    const question = props.question;
    const separatorClass = props.separatorClass;

    let separatorColor = "red";
    if (separatorClass === "orange") {
        separatorColor = "orange";
    } else if (separatorClass === "blue") {
        separatorColor = "#0097A7";
    }
    return (
        <Box
            display="flex"
            flexDirection="column"
            justifyContent="center"
            alignItems="center"
            border="1px solid #ececec"
            borderRadius="5px"
            mx="16px"
            px="8px"
            key={question}
        >
            <img src={MaterialIcon} style={{ color: separatorColor }} />
            <Box fontSize="24px" fontWeight="bold">
                {question}
            </Box>
            <Box width="32px" height="4px" my="8px" bgcolor={separatorColor} />
            <Box>{description}</Box>
        </Box>
    );
};

export default InfoCardMUI;
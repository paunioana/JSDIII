import React from "react";
import {Box, Button, Modal, TextField} from "@mui/material";
import BadgeIcon from '@mui/icons-material/Badge';
import AlternateEmailIcon from '@mui/icons-material/AlternateEmail';
import LocationCityIcon from '@mui/icons-material/LocationCity';
import WorkIcon from '@mui/icons-material/Work';
import LocalPhoneIcon from '@mui/icons-material/LocalPhone';
import DomainIcon from '@mui/icons-material/Domain';
import FormatListBulletedIcon from '@mui/icons-material/FormatListBulleted';
import CheckIcon from '@mui/icons-material/Check';
import CloseIcon from '@mui/icons-material/Close';

const UserModal = (props) => {
    const onClose = props.onClose;
    const userData = props.modalData.user;
    const todoData = props.modalData.todo;

    return (
        <Modal open onClose={() => onClose(undefined)}>
            <Box
                width="100%"
                height="100%"
                display="flex"
                alignItems="center"
                justifyContent="center"
            >
                <Box
                    position="relative"
                    borderRadius="15px"
                    width="50%"
                    height="50%"
                    bgcolor="#f5aa7f"
                    display="flex"
                    flexDirection="column"
                    p={3}
                >
                    <Box fontWeight="bold" py={1}>Person Info:</Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <BadgeIcon/>
                        <span>{userData.name}</span>
                    </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <AlternateEmailIcon/>
                        <span>{userData.email}</span>
                    </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <LocationCityIcon/>
                        <span>{`${userData.address.city}: ${userData.address.street}`}</span>
                    </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <DomainIcon/>
                        <span>{userData.website}</span>
                    </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <LocalPhoneIcon/>
                        <span>{userData.phone}</span>
                    </Box>

                    <Box my={2} width="100%" height="1px" bgcolor="#fafafa"/>

                    <Box fontWeight="bold" py={1}>Company Info:</Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <WorkIcon color="success"/>
                        <span>{userData.company.name}</span>
                    </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <BadgeIcon/>
                        <span>{userData.company.bs}</span>
                    </Box>

                    <Box my={2} width="100%" height="1px" bgcolor="#fafafa"/>

                    <Box fontWeight="bold" py={1}>Todo Info:</Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <FormatListBulletedIcon/>
                        <span>{todoData.title}</span>
                        {todoData.completed ? <CheckIcon color="success"/> : <CloseIcon color="error"/>}
                    </Box>

                    <Button variant="contained" onClick={onClose}>Close Modal</Button>
                </Box>
            </Box>
        </Modal>
    );
};

export default UserModal;
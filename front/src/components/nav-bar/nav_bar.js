
  
import { useEffect, useRef, useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
 import style from './nav_bar.module.css';
 import SettingsIcon from '@mui/icons-material/Settings';
 import MapIcon from '@mui/icons-material/Map';
 import GroupIcon from '@mui/icons-material/Group';
 import DriveEtaIcon from '@mui/icons-material/DriveEta';
 import DataUsageIcon from '@mui/icons-material/DataUsage';
 import ContactMailOutlinedIcon from '@mui/icons-material/ContactMailOutlined';
 import DashboardIcon from '@mui/icons-material/Dashboard';
const sidebarNavItems = [
  
    {
        display: 'Fleet Overview',
        icon: <MapIcon />,
        to: '/fleet_overview',
        section: '/fleet_overview'
    },
    {
        display: 'Teleoperation',
        icon: <DriveEtaIcon />,
        to: '/teleoperation',
        section: 'teleoperation'
    },
   {
        display: 'Monitoring',
        icon: <DataUsageIcon />,
        to: '/monitoring',
        section: 'monitoring'
    },
    {
        display: 'Time Capsule',
        icon: <SettingsIcon />,
        to: '/Time_capsule',
        section: 'Time_capsule'
    },

]

const Sidebar = () => {
    // const [activeIndex, setActiveIndex] = useState(0);
    // const [stepHeight, setStepHeight] = useState(0);
    // const sidebarRef = useRef();
    // const location = useLocation();

    // // change active index
    // useEffect(() => {
    //     const curPath = window.location.pathname.split('/')[1];
    //     const activeItem = sidebarNavItems.find(item => item.section === curPath);
    //     setActiveIndex(curPath.length === 0 ? 0 : activeItem);
    //     console.log(curPath)
    // }, [location]);

    return <div className={style.sidebar} >
        <div className={style.topBar}></div>
        
         <Link  style={{textDecoration:'none'}} to={"/"}>
             <div className={style.logo}>
                
                  <h1 className="orderCart">
                  <DashboardIcon style={{fontSize:'4rem'}} />
                 </h1 > <span style={{position:'relative' , bottom:'2vh'}}>Dashboard </span></div> 
         </Link>  
  
            {
                sidebarNavItems.map((item, index) => (
                    <Link style={{textDecoration:'none'}} to={item.to} key={index}>
                        <div className= {style.item}>
                            <div style={{marginRight:'5px'}} >
                                {item.icon}
                            </div>
                            <div >
                                {item.display}
                            </div>
                        </div>
                  </Link>
                ))
            }
        </div>
  ;
};

export default Sidebar;
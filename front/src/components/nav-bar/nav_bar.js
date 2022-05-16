
  
import { useEffect, useRef, useState } from 'react';
import { Link } from 'react-router-dom';
 import style from './nav_bar.module.css';
 import ConnectingAirportsIcon from '@mui/icons-material/ConnectingAirports';
 import SettingsRemoteIcon from '@mui/icons-material/SettingsRemote';
 import MonitorIcon from '@mui/icons-material/Monitor';
 import DashboardIcon from '@mui/icons-material/Dashboard';
 import TimelapseIcon from '@mui/icons-material/Timelapse';
const sidebarNavItems = [
  
    {
        display: 'Fleet Overview',
        icon: <ConnectingAirportsIcon />,
        to: '/fleet_overview',
        section: '/fleet_overview'
    },
    {
        display: 'Teleoperation',
        icon: <SettingsRemoteIcon />,
        to: '/teleoperation',
        section: 'teleoperation'
    },
   {
        display: 'Monitoring',
        icon: <MonitorIcon />,
        to: '/monitoring',
        section: 'monitoring'
    },
    {
        display: 'Time Capsule',
        icon: <TimelapseIcon />,
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
import * as React from 'react';
import PropTypes from 'prop-types';
import SwipeableViews from 'react-swipeable-views';
import { useTheme } from '@mui/material/styles';
import AppBar from '@mui/material/AppBar';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import { BarChart } from './barChart';
import {
    CircularProgressbar,
    CircularProgressbarWithChildren,
    buildStyles
  } from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
import { Chart as ChartJS, ArcElement, Tooltip, Legend } from 'chart.js';
import { Pie } from 'react-chartjs-2';
import LineChart from './lineChart'
  
  ChartJS.register(ArcElement, Tooltip, Legend);
  


function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`full-width-tabpanel-${index}`}
      aria-labelledby={`full-width-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.number.isRequired,
  value: PropTypes.number.isRequired,
};

function a11yProps(index) {
  return {
    id: `full-width-tab-${index}`,
    'aria-controls': `full-width-tabpanel-${index}`,
  };
}

export default function KPI() {
  const theme = useTheme();
  const [value, setValue] = React.useState(0);


  const Piedata =  {
    labels: ['Offline', 'Activee' ],
    datasets: [
      {
        label: '# of Votes',
        data: [80, 20],
        backgroundColor: [
          'rgba(255, 99, 132, 0.2)',
          'rgba(54, 162, 235, 0.2)',
          'rgba(255, 206, 86, 0.2)',
          'rgba(75, 192, 192, 0.2)',
          'rgba(153, 102, 255, 0.2)',
          'rgba(255, 159, 64, 0.2)',
        ],
        borderColor: [
          'rgba(255, 99, 132, 1)',
          'rgba(54, 162, 235, 1)',
          'rgba(255, 206, 86, 1)',
          'rgba(75, 192, 192, 1)',
          'rgba(153, 102, 255, 1)',
          'rgba(255, 159, 64, 1)',
        ],
        borderWidth: 1,
      },
    ],
  };

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleChangeIndex = (index) => {
    setValue(index);
  };

  return (
    <Box sx={{ bgcolor: 'background.paper', width: 500 }}>
      <AppBar position="static">
        <Tabs
          value={value}
          onChange={handleChange}
          indicatorColor="secondary"
          textColor="inherit"
          variant="fullWidth"
          aria-label="full width tabs example"
        >
          <Tab label="Item One" {...a11yProps(0)} ></Tab>
          <Tab label="Item Two" {...a11yProps(1)} />
          <Tab label="Item Three" {...a11yProps(2)} />
          <Tab label="Item Four" {...a11yProps(3)} />
        </Tabs>
      </AppBar>
      <SwipeableViews
        axis={theme.direction === 'rtl' ? 'x-reverse' : 'x'}
        index={value}
        onChangeIndex={handleChangeIndex}
      >
        <TabPanel value={value} index={0} dir={theme.direction}>
            <Paper style={{display:'flex',justifyContent:'center'}} sx={{flexWrap: 'wrap' }} variant="outlined" square>
                  <BarChart />
            </Paper>
        </TabPanel>
        <TabPanel value={value} index={1} dir={theme.direction}>
            <Paper sx={{flexWrap: 'wrap',
                        m: 1,
                        minWidth:300,
                        minHeight:200,
                        }} variant="outlined" square>
                     <h2> Actives Aircrafts :</h2>
                      <Pie data={Piedata} />
            </Paper>
        </TabPanel>
        <TabPanel value={value} index={2} dir={theme.direction}>
            <Paper sx={{flexWrap: 'wrap',
                    m: 1,
                    minWidth:300,
                    minHeight:200,
                    }} variant="outlined" square>
               <LineChart />
            </Paper>
        </TabPanel>
        <TabPanel value={value} index={3} dir={theme.direction}>
            <Paper sx={{flexWrap: 'wrap',
                    m: 1,
                    minWidth:300,
                    minHeight:200,
                    }} variant="outlined" square>
                Item Four
            </Paper>
        </TabPanel>
      </SwipeableViews>
    </Box>
  );
}

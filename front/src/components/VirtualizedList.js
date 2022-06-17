import React from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import { FixedSizeList } from 'react-window';
import LineChartMonitoring from './lineChartMonitoring';
import {data}  from './lineChartMonitoring';

import { Line } from 'react-chartjs-2';
import {options} from './lineChartMonitoring';

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
    height: 400,
    maxWidth: 300,
    backgroundColor: theme.palette.background.paper},    
}));
//theme.palette.background.paper


export function renderRow(props) {
  const { index, style } = props;
  const names=[
  'aileron',
  'elevator',
  'rudder'
  ,'flaps'
  ,'slats'
  ,'speedbrake'
  ,'throttle0'
  ,'throttle1'
  ,'engine-pump0'
  ,'engine-pump1'
  ,'electric-pump0'
  ,'electric-pump1'
  ,'external-power'
  ,'APU generator'
  ,'latitude-deg'
  ,'longitude-deg'
  ,'altitude-ft'
  ,'roll-deg'
  ,'pitch-deg'
  ,'heading-deg'
  ,'side-slip-you'
  ,'airspeed-kt'
  ,'glideslope'
  ,'vertical-speed-fps'
  ,'airspeed-indicator_indicated-speed-kt'
  ,'altimeter_indicated-altitude-ft'
  ,'altimeter_pressure-alt-ft'
  ,'attitude-indicator_indicated-pitch-deg'
  ,'attitude-indicator_indicated-roll-deg'
  ,'attitude-indicator_internal-pitch-deg'
  ,'attitude-indicator_internal-roll-deg'
  ,'encoder_indicated-altitude-ft'
  ,'encoder_pressure-alt-ft'
  ,'gps_indicated-altitude-ft'
  ,'gps_indicated-ground-speed-kt'
  ,'gps_indicated-vertical-speed'
  ,'indicated-heading-deg'
  ,'magnetic-compass_indicated-heading-deg'
  ,'slip-skid-ball_indicated-slip-skid'
  ,'turn-indicator_indicated-turn-rate'
  ,'vertical-speed-indicator_indicated-speed-fpm'
  ,'engine_rpm'];

  function handleClick(e) {
   
      console.log(names[index]);
      console.log(data.datasets[0].borderColor);
      data.datasets[0].borderColor='green';
      console.log(data.datasets[0].borderColor);
      // props.setValue();


    // console.log(names[index]);
    // console.log(data.datasets[0].borderColor);
    // data.datasets[0].borderColor='green';
    // console.log(data.datasets[0].borderColor);
    
  }
  
  return (
    
    <ListItem button style={style} key={index} value={`${ names[index]}`}>
      {/* <ListItemText primary={`Item ${index + 1}`} /> */}
     
      <ListItemText primary={`${ names[index]}`} onClick={handleClick}/>
    </ListItem >
    
  );
}

renderRow.propTypes = {
  index: PropTypes.number.isRequired,
  style: PropTypes.object.isRequired,
  
};

export default function VirtualizedList(props) {
  const classes = useStyles();
  

  return (
    <div className={classes.root} >
      <FixedSizeList height={400} width={300} itemSize={46} itemCount={41} setValue={props.setValue} onItemsRendered={e =>console.log(e)}>
        {renderRow}
      </FixedSizeList>
    </div>
  );
}

import React from 'react';
import PropTypes from 'prop-types';
import { makeStyles } from '@material-ui/core/styles';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';
import { FixedSizeList } from 'react-window';

const useStyles = makeStyles((theme) => ({
  root: {
    width: '100%',
    height: 400,
    maxWidth: 300,
    backgroundColor: theme.palette.background.paper,
  },
}));


function renderRow(props) {
  const { index, style } = props;
  const names=['aileron',
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
  return (
    
    <ListItem button style={style} key={names[index]}>
      {/* <ListItemText primary={`Item ${index + 1}`} /> */}
      <ListItemText primary={`${ names[index]}`} />
    </ListItem>
    
  );
}

renderRow.propTypes = {
  index: PropTypes.string.isRequired,
  style: PropTypes.object.isRequired,
};

export default function VirtualizedList() {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <FixedSizeList height={400} width={300} itemSize={46} itemCount={41}>
        {renderRow}
      </FixedSizeList>
    </div>
  );
}

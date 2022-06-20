import React, { forwardRef } from "react";
import PropTypes from "prop-types";
import { makeStyles } from "@material-ui/core/styles";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import { FixedSizeList } from "react-window";
import LineChartMonitoring from "./lineChartMonitoring";
import { data } from "./lineChartMonitoring";

import { Line } from "react-chartjs-2";
import { options } from "./lineChartMonitoring";
import fakeData from "./fakeData";

const useStyles = makeStyles((theme) => ({
  root: {
    width: "100%",
    height: 400,
    maxWidth: 300,
    backgroundColor: theme.palette.background.paper,
  },
}));
//theme.palette.background.paper

export function renderRow(props) {
  const { index, style } = props;
  const names = [
    "airspeedKt",
    "throttle1",
    "throttle0",
    "engine-pump1",
    "electric-pump0",
    "gps_indicated-vertical-speed",
    "engine-pump0",
    "electric-pump1",
    "attitude-indicator_indicated-pitch-deg",
    "encoder_indicated-altitude-ft",
    "gps_indicated-ground-speed-kt",
    "vertical-speed-fps",
    "flaps",
    "heading-deg",
    "elevator",
    "longitude-deg",
    "altimeter_indicated-altitude-ft",
    "encoder_pressure-alt-ft",
    "rudder",
    "latitude-deg",
    "indicated-heading-deg",
    "aileron",
    "roll-deg",
    "speedbrake",
    "external-power",
    "slats",
    "airspeed-indicator_indicated-speed-kt",
    "gps_indicated-altitude-ft",
    "vertical-speed-indicator_indicated-speed-fpm",
    "pitch-deg",
    "side-slip-deg",
    "altimeter_pressure-alt-ft",
    "engine_rpm",
    "glideslope",
    "magnetic-compass_indicated-heading-deg",
    "altitude-ft",
    "attitude-indicator_indicated-roll-deg",
    "slip-skid-ball_indicated-slip-skid",
    "APU-generator",
    "attitude-indicator_internal-roll-deg",
    "turn-indicator_indicated-turn-rate",
    "attitude-indicator_internal-pitch-deg",
  ];
  //add all the names of the sensors
  return (
    <ListItem button style={style} key={index} value={`${names[index]}`}>
      {/* <ListItemText primary={`Item ${index + 1}`} /> */}

      <ListItemText primary={`${names[index]}`} />
    </ListItem>
  );
}

renderRow.propTypes = {
  index: PropTypes.number.isRequired,
  style: PropTypes.object.isRequired,
};

export default function VirtualizedList(props) {
  const classes = useStyles();
  const func = (e) => {
    props.setValue(e.target.firstChild.nodeValue);
  };

  const outerElementType = forwardRef((props, ref) => <div ref={ref} onClick={func} {...props} />);

  return (
    <div className={classes.root}>
      <FixedSizeList outerElementType={outerElementType} height={400} width={300} itemSize={46} itemCount={41}>
        {renderRow}
      </FixedSizeList>
    </div>
  );
}

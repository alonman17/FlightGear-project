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
import fakeFlights from "./fakeFlight";

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
  const names = [];
  for (let i = 0; i < fakeFlights.length; i++) {
    names.push(fakeFlights[i].id);
  }

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

export default function ComplitedFlightsList(props) {
  const classes = useStyles();
  const func = (e) => {
    // props.setVal(e.target.firstChild.nodeValue);
    // props.setVal(e.target.value);
    console.log(e.target.firstChild.nodeValue);
    props.setId(e.target.firstChild.nodeValue);
  };

  const outerElementType = forwardRef((props, ref) => (
    <div ref={ref} onClick={func} {...props} />
  ));

  return (
    <div className={classes.root}>
      <FixedSizeList
        outerElementType={outerElementType}
        height={400}
        width={300}
        itemSize={46}
        itemCount={fakeFlights.length}
      >
        {renderRow}
      </FixedSizeList>
    </div>
  );
}

import moment, { Moment } from "moment"

function getToday(): Moment {
    return moment()
}

function getToday_YYMMDD(): string {
    return FormatDateTO_YYMMDD(getToday())
}


function FormatDateTO_YYMMDD(date: Moment):string {
    return date.format("YYYY年MM月DD日")
}

export {
    getToday_YYMMDD
}
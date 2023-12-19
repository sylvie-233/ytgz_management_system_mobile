import request from "@/utils/request"

export function getStudentList() {
    return request({
        url: "/student/all",
        method: "GET"
    })
}
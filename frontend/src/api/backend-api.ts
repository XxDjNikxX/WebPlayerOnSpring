import axios, {AxiosResponse} from 'axios'

export const axiosApi = axios.create({
    baseURL: `/api`,
    timeout: 1000,
    headers: { 'Content-Type': 'application/json' }
});


export default {
    home(): Promise<AxiosResponse<string>> {
        return axiosApi.get(`/`);
    },
    about(): Promise<AxiosResponse<string>> {
        return axiosApi.get(`/about`);
    },
    contacts(): Promise<AxiosResponse<string>> {
        return axiosApi.get(`/contacts`);
    },
}
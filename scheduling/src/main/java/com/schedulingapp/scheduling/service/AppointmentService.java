package com.schedulingapp.scheduling.service;

import com.schedulingapp.scheduling.dto.AppointmentVO;
import com.schedulingapp.scheduling.dto.AppointmentsWithEmployeeCustomerInfo;
import com.schedulingapp.scheduling.dto.EmployeeVO;
import com.schedulingapp.scheduling.model.Appointment;
import com.schedulingapp.scheduling.model.Customer;
import com.schedulingapp.scheduling.model.Employee;
import com.schedulingapp.scheduling.repository.AppointmentRepository;
import com.schedulingapp.scheduling.repository.CustomerRepository;
import com.schedulingapp.scheduling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService{

    AppointmentRepository appointmentRepository;
    CustomerRepository customerRepository;
    EmployeeRepository employeeRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, CustomerRepository customerRepository, EmployeeRepository employeeRepository){
        this.appointmentRepository = appointmentRepository;
        this.customerRepository = customerRepository;
        this.employeeRepository = employeeRepository;
    }

    public String addAppointment(AppointmentVO appointment){

       try {
           Appointment addAppointment = new Appointment();

           addAppointment.setTitle(appointment.getTitle());
           addAppointment.setStartDate(appointment.getStartDate());
           addAppointment.setStartTime(appointment.getStartTime());
           addAppointment.setEndDate(appointment.getEndDate());
           addAppointment.setEndTime(appointment.getEndTime());
           addAppointment.setCreatedDate(appointment.getCreatedDate());
           addAppointment.setLastUpdated(new Timestamp(System.currentTimeMillis()));
           //TODO - update to user
           addAppointment.setCreatedBy("Greg Boydston");
           //TODO - update to user
           addAppointment.setLastUpdatedBy("Greg Boydston");
           addAppointment.setCustomerId(appointment.getCustomerId());
           addAppointment.setEmployeeId(appointment.getEmployeeId());

           appointmentRepository.save(addAppointment);
           return "Success";
       }catch(Exception e){
           return "Fail";
       }
    }


    public AppointmentsWithEmployeeCustomerInfo getAllAppointments(){
        List<AppointmentVO> appointmentVOList = new ArrayList<>();
        List<Appointment> appointmentList = new ArrayList<>();
        List<Customer> customerList = new ArrayList<>();
        List<Employee> employeeList = this.employeeRepository.getEmployees();
        List<Integer> employeeIdList = new ArrayList<>();
        List<Integer> customerIdList = new ArrayList<>();

        appointmentList = this.appointmentRepository.findAll();

        appointmentList.forEach(l -> {
            AppointmentVO appointmentVO = new AppointmentVO();
            appointmentVO.setAppointmentId(Integer.valueOf(l.getAppointmentId().toString()));
            appointmentVO.setCustomerId(l.getCustomerId());
            appointmentVO.setEmployeeId(l.getEmployeeId());
            appointmentVO.setTitle(l.getTitle());
            appointmentVO.setStartDate(l.getStartDate());
            appointmentVO.setStartTime(l.getStartTime());
            appointmentVO.setEndDate(l.getEndDate());
            appointmentVO.setEndTime(l.getEndTime());
            appointmentVO.setCreatedDate(l.getCreatedDate());
            appointmentVO.setCreatedBy(l.getCreatedBy());
            appointmentVO.setLastUpdated(l.getLastUpdated());
            appointmentVO.setLastUpdatedBy(l.getLastUpdatedBy());

            appointmentVOList.add(appointmentVO);
            if(employeeIdList.size() == 0 || !employeeIdList.contains(l.getEmployeeId())){
                employeeIdList.add(l.getEmployeeId());
            }
            if(customerIdList.size() == 0 || !customerIdList.contains(l.getCustomerId())){
                customerIdList.add(l.getCustomerId());
            }
        });

        AppointmentsWithEmployeeCustomerInfo appointmentsWithEmployeeCustomerInfo = new AppointmentsWithEmployeeCustomerInfo();

        for(int i = 1; i < employeeIdList.size(); i++){
            EmployeeVO newEmployee = new EmployeeVO();
            Employee emp = new Employee();
            for(int x = 0; x < employeeList.size(); x++){
                if(employeeList.get(x).getEmployeeId() == employeeIdList.get(i)){
                    EmployeeVO employeeVO = new EmployeeVO();
                    employeeVO.setId(employeeList.get(x).getEmployeeId());
                    employeeVO.setEmployeeName(employeeList.get(x).getEmployeeName());
                    employeeVO.setEmail(employeeList.get(x).getEmail());
                    newEmployee = employeeVO;
                }
            }
            emp.setEmployeeId(newEmployee.getId());
            emp.setEmployeeName(newEmployee.getEmployeeName());
            emp.setEmail(newEmployee.getEmail());
            employeeList.add(emp);
        }
        for(int i = 0; i < customerIdList.size(); i++){
            Customer newCustomer = new Customer();
            newCustomer = this.customerRepository.findByCustomerId(Long.valueOf(customerIdList.get(i).toString()));
            customerList.add(newCustomer);
        }
        appointmentsWithEmployeeCustomerInfo.customerList = customerList;
        appointmentsWithEmployeeCustomerInfo.employeeList = employeeList;

        for(int i = 0; i < appointmentVOList.size(); i++){
            for(int j = 0; j < customerList.size(); j++){
                if(appointmentVOList.get(i).getCustomerId() == customerList.get(j).getCustomerId()){
                    appointmentVOList.get(i).setCustomerName(customerList.get(j).getCustomerName());
                }
            }
            for(int x = 0; x < employeeList.size(); x++){
                if(employeeList.get(x).getEmployeeId() == appointmentVOList.get(i).getEmployeeId()){
                    appointmentVOList.get(i).setEmployeeName(employeeList.get(x).getEmployeeName());
                }
            }
        }

        appointmentsWithEmployeeCustomerInfo.appointmentVOList = appointmentVOList;
        return appointmentsWithEmployeeCustomerInfo;
    }


    public void updateAppointment(AppointmentVO appointmentVO, Integer id){
        Appointment appointment = appointmentRepository.findByAppointmentId(Long.valueOf(id.toString()));
        appointment.setAppointmentId(appointment.getAppointmentId());
        appointment.setTitle(appointmentVO.getTitle());
        appointment.setEmployeeId(appointmentVO.getEmployeeId());
        appointment.setCustomerId(appointmentVO.getCustomerId());
        appointment.setStartDate(appointmentVO.getStartDate());
        appointment.setStartTime(appointmentVO.getStartTime());
        appointment.setEndDate(appointmentVO.getEndDate());
        appointment.setEndTime(appointmentVO.getEndTime());
        appointment.setLastUpdated(appointmentVO.getLastUpdated());
        this.appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Integer id){
        this.appointmentRepository.deleteById(Long.valueOf(id.toString()));
    }

    public void deleteAppointmentsByCustomerId(Integer id){
        this.appointmentRepository.deleteAppointmentsByCustomerId(id);
    }

    public ArrayList<Integer> getAllAppointmentsByCustomerId(Integer id){
        ArrayList<Long> appointmentIdList = this.appointmentRepository.findAllAppointmentIdsByCustomerId(id);
        ArrayList<Integer> idList = new ArrayList<>();

        appointmentIdList.forEach(i ->{
            idList.add(i.intValue());
        });

        return idList;
    }

}

package com.drchrono.dc.constants;

public class SqlConstants {

  public final static String insertPatient =
      "INSERT INTO public.patient (id,chart_id,first_name,middle_name,"
          + "last_name,date_of_birth,gender,social_security_number,race,ethnicity,patient_photo,"
          + "patient_payment_profile,patient_status,home_phone,cell_phone,office_phone,email,"
          + "address,city,state,zip_code,emergency_contact_name,emergency_contact_phone,"
          + "emergency_contact_relation,employer,employer_address,employer_city,employer_state,"
          + "employer_zip_code,disable_sms_messages,doctor,primary_care_physician,"
          + "date_of_first_appointment,date_of_last_appointment,default_pharmacy,referring_source,"
          + "copay,responsible_party_name,responsible_party_relation,responsible_party_phone,"
          + "responsible_party_email,updated_at ) values "
          + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


  public final static String getPatient = "SELECT * from public.patient where id = :ID";


  public final static String insertAppointment =
      "INSERT into public.appointments (appointmentid,allow_overlapping,appt_is_break,"
          + "base_recurring_appointment,color,created_at,deleted_flag,doctor,duration,exam_room,"
          + "is_walk_in,notes,office,patient,profile,reason,recurring_appointment,scheduled_time,"
          + "status,updated_at) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


  public final static String getAppointment = "SELECT * from public.appointments where appointmentid = :appointmentid";


}

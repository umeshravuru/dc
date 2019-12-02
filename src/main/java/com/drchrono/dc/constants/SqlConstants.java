package com.drchrono.dc.constants;

public class SqlConstants {

  public final static String insertUser =
      "INSERT INTO public.USER (id,chart_id,first_name,middle_name,"
          + "last_name,date_of_birth,gender,social_security_number,race,ethnicity,patient_photo,"
          + "patient_payment_profile,patient_status,home_phone,cell_phone,office_phone,email,"
          + "address,city,state,zip_code,emergency_contact_name,emergency_contact_phone,"
          + "emergency_contact_relation,employer,employer_address,employer_city,employer_state,"
          + "employer_zip_code,disable_sms_messages,doctor,primary_care_physician,"
          + "date_of_first_appointment,date_of_last_appointment,default_pharmacy,referring_source,"
          + "copay,responsible_party_name,responsible_party_relation,responsible_party_phone,"
          + "responsible_party_email,updated_at ) values "
          + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


  public final static String getUser = "SELECT * from public.USER where id = :ID";


}

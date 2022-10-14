package com.biddy.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.biddy.android.databinding.FragmentLoginBinding
import com.biddy.android.models.UserAuthData

class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? =null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding.btnSignUp.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun getUserRequest() : UserAuthData {
        val emailAddress = binding.txtEmail.text.toString()
        val password = binding.txtPassword.text.toString()
        return UserAuthData(emailAddress,password)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
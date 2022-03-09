package ir.mohammadhf.alibabainternationaltask.feature.select

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.mohammadhf.alibabainternationaltask.R
import ir.mohammadhf.alibabainternationaltask.databinding.FragmentSelectFlightBinding
import ir.mohammadhf.alibabainternationaltask.feature.SharedViewModel

@AndroidEntryPoint
class SelectFlightFragment : Fragment() {
    private val SelectFlightViewModel: SelectFlightViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var _binding: FragmentSelectFlightBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSelectFlightBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            travelDestEt.addTextChangedListener {
                SelectFlightViewModel.travelDestTxt = it.toString()
            }

            travelFromEt.addTextChangedListener {
                SelectFlightViewModel.travelFromTxt = it.toString()
            }

            btnSearch.setOnClickListener {
                sharedViewModel.setDestination(SelectFlightViewModel.travelDestTxt)
                findNavController().popBackStack()
            }

            btnSelectDate.setOnClickListener {
                if (datePicker.isVisible) {
                    datePicker.visibility = GONE
                    btnSelectDate.text = getString(R.string.choose_date)
                    datePicker.let {
                        val date = "${it.dayOfMonth} / ${it.month} / ${it.year}"
                        SelectFlightViewModel.selectedDate = date
                        selectedDateTv.text = date
                    }
                } else {
                    datePicker.visibility = VISIBLE
                    btnSelectDate.text = getString(R.string.done)
                }
            }

            backIb.setOnClickListener { findNavController().popBackStack() }
        }

        sharedViewModel.apply {
            destination.observe(viewLifecycleOwner) { destTxt ->
                binding.travelDestEt.let { if (!it.hasFocus()) it.setText(destTxt.toString()) }
            }
        }

        SelectFlightViewModel.onFormComplete.observe(viewLifecycleOwner) {
            binding.btnSearch.isEnabled = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}